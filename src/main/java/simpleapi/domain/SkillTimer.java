package simpleapi.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(Include.NON_NULL)
public class SkillTimer implements Serializable {
	
	private static final long serialVersionUID = -7731829501735932273L;
	
	private int id;
	private long time;
	
	public SkillTimer() { }

	public SkillTimer(int id, long time) {
		super();
		this.id = id;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
