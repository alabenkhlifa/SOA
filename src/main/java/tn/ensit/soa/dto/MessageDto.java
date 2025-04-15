package tn.ensit.soa.dto;

public class MessageDto {
    private String channelId;

    private Long authorId;

    public MessageDto(String channelId, Long authorId) {
        this.channelId = channelId;
        this.authorId = authorId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
