package com.mccken201908.order.model;

import java.io.Serializable;
import java.util.Date;

/**
 * mccken_order
 *
 * @author
 */
public class McckenOrder implements Serializable {
	private Integer id;

	private String orderId;

	private String uuid;

	private Date createTime;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		McckenOrder other = (McckenOrder) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
				&& (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
		result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", orderId=").append(orderId);
		sb.append(", uuid=").append(uuid);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}