import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        
        if(cacheSize == 0) return cities.length * 5;


        for (String city : cities) {
            city = city.toUpperCase();
            
            if(arrayList.contains(city)) {
                arrayList.remove(city);
                arrayList.add(city);
                answer += 1;
            } else {
                if(arrayList.size() == cacheSize) {
                    arrayList.remove(0);
                }
                arrayList.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}