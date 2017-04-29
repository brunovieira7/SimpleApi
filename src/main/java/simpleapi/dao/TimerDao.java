package simpleapi.dao;

import simpleapi.domain.SkillTimer;
import simpleapi.exception.NotFoundException;

public interface TimerDao {
	public long getTime(int id) throws NotFoundException;
	public void saveTime(SkillTimer timer);
}
