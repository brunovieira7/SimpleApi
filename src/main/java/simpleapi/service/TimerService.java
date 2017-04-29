package simpleapi.service;

import simpleapi.domain.SkillTimer;
import simpleapi.exception.NotFoundException;

public interface TimerService {
	public SkillTimer getBestTime(int id) throws NotFoundException;
	public void checkTime(SkillTimer time);
}
