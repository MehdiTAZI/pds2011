package fr.esiag.mezzodijava.nuclear.systemstatemonitor.tools;

import java.io.Serializable;

public class EventInfoPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long time;
	private int code;
	private String type;
	
	public EventInfoPK() {
		super();
	}
	public EventInfoPK(Long time, int code, String type) {
		super();
		this.code = code;
		this.type = type;
		this.time = time;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventInfoPK other = (EventInfoPK) obj;
		if (code != other.code)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
