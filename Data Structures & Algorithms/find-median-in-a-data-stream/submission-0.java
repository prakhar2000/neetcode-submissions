class MedianFinder {

    PriorityQueue<Integer> lefthalf;
    PriorityQueue<Integer> righthalf;


    public MedianFinder() {
        this.lefthalf= new PriorityQueue<>(Collections.reverseOrder());
        this.righthalf= new PriorityQueue<>();
    
        
    }
    
    public void addNum(int num) {
        if(lefthalf.isEmpty()||num<=lefthalf.peek()){
            lefthalf.offer(num);

        }else{
            righthalf.offer(num);

        }

        if (lefthalf.size() > righthalf.size() + 1) {
            righthalf.offer(lefthalf.poll());
        } else if (righthalf.size() > lefthalf.size() + 1) {
            lefthalf.offer(righthalf.poll());
        }
        
        
    }
    
    public double findMedian() {
        if(lefthalf.size()>righthalf.size()){
            return (double)lefthalf.peek();

        }else if (lefthalf.size()<righthalf.size()){
            return (double)righthalf.peek();

        }else{
            return (double)((lefthalf.peek()+righthalf.peek())/ 2.0);
        }
        
    }
}
