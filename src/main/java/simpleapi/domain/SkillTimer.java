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
	private float time;
	
	public SkillTimer() { }

	public SkillTimer(int id, float time) {
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

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

}
