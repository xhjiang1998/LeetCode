package xhjiang.scene.Test.Model;

/**
 * @description: 通知领域对象
 * @author: xhjiang
 * @date: 2025/4/14 16:30
 */
public class NotifyModel {
    private String bizType;
    private Long applyAmt;

    public NotifyModel(String bizType) {
        this.bizType = bizType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Long getApplyAmt() {
        return applyAmt;
    }

    public void setApplyAmt(Long applyAmt) {
        this.applyAmt = applyAmt;
    }
}

