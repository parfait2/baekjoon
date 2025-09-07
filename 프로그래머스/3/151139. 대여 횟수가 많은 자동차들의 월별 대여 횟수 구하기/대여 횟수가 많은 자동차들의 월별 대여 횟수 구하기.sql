SELECT MONTH(START_DATE) AS MONTH
     , CAR_ID
     , COUNT(1) AS RECORDS
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
  WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    AND CAR_ID IN (
                   SELECT CAR_ID
                     FROM (
                            SELECT CAR_ID
                                 , COUNT(HISTORY_ID) AS HIST_CNT
                              FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                             WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
                          GROUP BY CAR_ID
                            HAVING HIST_CNT >= 5
                          ) A
                  )
GROUP BY MONTH
       , CAR_ID
  HAVING MONTH IN (8, 9, 10)
ORDER BY MONTH
       , CAR_ID DESC