package io.arklitium.matrix.client.rest.jsonmodel;

public class GetPublicRoomsRespData {

    private PublicRoomsChunk chunk;
    private String next_batch;
    private String prev_btach;
    private Long total_room_count_estimate;

    public GetPublicRoomsRespData() {
    }

    public GetPublicRoomsRespData(PublicRoomsChunk chunk, String next_batch, String prev_btach, Long total_room_count_estimate) {
        this.chunk = chunk;
        this.next_batch = next_batch;
        this.prev_btach = prev_btach;
        this.total_room_count_estimate = total_room_count_estimate;
    }

    public PublicRoomsChunk getChunk() {
        return chunk;
    }

    public void setChunk(PublicRoomsChunk chunk) {
        this.chunk = chunk;
    }

    public String getNext_batch() {
        return next_batch;
    }

    public void setNext_batch(String next_batch) {
        this.next_batch = next_batch;
    }

    public String getPrev_btach() {
        return prev_btach;
    }

    public void setPrev_btach(String prev_btach) {
        this.prev_btach = prev_btach;
    }

    public Long getTotal_room_count_estimate() {
        return total_room_count_estimate;
    }

    public void setTotal_room_count_estimate(Long total_room_count_estimate) {
        this.total_room_count_estimate = total_room_count_estimate;
    }

    @Override
    public String toString() {
        return "GetPublicRoomsRespData{" +
                "chunk=" + chunk +
                ", next_batch='" + next_batch + '\'' +
                ", prev_btach='" + prev_btach + '\'' +
                ", total_room_count_estimate=" + total_room_count_estimate +
                '}';
    }

}
