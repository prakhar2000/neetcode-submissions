class TimeMap {

   private static class Data {
        String value;
        int timestamp;

        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
private Map<String, List<Data>> map;

    public TimeMap() {
        map= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)){
            return "";
        }

        List<Data> l= map.get(key);
        int left=0;
        int right =l.size()-1;
        String res="";

        while(left<=right){
            int mid= left+ (right-left)/2;
            if(l.get(mid).timestamp<=timestamp){
                res= l.get(mid).value;
                left= mid+1;
            }else{
                right= mid-1;
            }
        }
        return res;
    }
}
