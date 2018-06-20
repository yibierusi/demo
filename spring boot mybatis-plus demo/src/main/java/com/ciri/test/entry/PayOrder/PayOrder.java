package com.ciri.test.entry.PayOrder;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouhy
 * @since 2018-06-13
 */
@TableName("pay_order")
public class PayOrder extends Model<PayOrder> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("user_id")
	private String userId;
	@TableField("user_info_id")
	private Integer userInfoId;
    /**
     * 微信唯一标示
     */
	@TableField("open_id")
	private String openId;
    /**
     * 自定义参数
     */
	private String attach;
    /**
     * 商品简单描述
     */
	private String body;
    /**
     * 商品详情
     */
	private String detail;
    /**
     * 商品订单号
     */
	@TableField("out_trade_no")
	private String outTradeNo;
    /**
     * 用户端IP
     */
	@TableField("spbill_create_ip")
	private String spbillCreateIp;
    /**
     * 金额（分）
     */
	@TableField("total_fee")
	private Integer totalFee;
    /**
     * 支付类型
     */
	@TableField("trade_type")
	private String tradeType;
	@TableField("create_time")
	private Date createTime;
	@TableField("update_time")
	private Date updateTime;
    /**
     * 操作人
     */
	private String operator;
    /**
     * 类型：微信充值、
     */
	private String type;
    /**
     * 状态
     */
	private String status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PayOrder{" +
			"id=" + id +
			", userId=" + userId +
			", userInfoId=" + userInfoId +
			", openId=" + openId +
			", attach=" + attach +
			", body=" + body +
			", detail=" + detail +
			", outTradeNo=" + outTradeNo +
			", spbillCreateIp=" + spbillCreateIp +
			", totalFee=" + totalFee +
			", tradeType=" + tradeType +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", operator=" + operator +
			", type=" + type +
			", status=" + status +
			"}";
	}
}
