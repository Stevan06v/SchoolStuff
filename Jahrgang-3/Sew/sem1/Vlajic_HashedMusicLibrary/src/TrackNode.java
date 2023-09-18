public class  TrackNode {

    private Track track;
    private TrackNode next;
    private int bucketIndex;
    private int listIndex;

    public boolean hasNext(){
        if(this.next == null){
            return false;
        }else{
            return true;
        }
    }

    public Track getTrack() {
        return track;
    }

    public TrackNode getNext() {
        return next;
    }

    public void setNext(TrackNode next) {
        this.next = next;
    }

    public int getBucketIndex() {
        return bucketIndex;
    }

    public int getListIndex() {
        return listIndex;
    }

    public TrackNode(Track track, int bucketIndex, int listIndex) {
        this.track = track;
        this.bucketIndex = bucketIndex;
        this.listIndex = listIndex;
    }
}
