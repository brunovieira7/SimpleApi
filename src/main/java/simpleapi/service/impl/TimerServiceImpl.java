package simpleapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simpleapi.dao.TimerDao;
import simpleapi.domain.SkillTimer;
import simpleapi.exception.NotFoundException;
import simpleapi.service.TimerService;

@Service
public class TimerServiceImpl implements TimerService {

	@Autowired
	private TimerDao timerDao;
	
	@Override
	public SkillTimer getBestTime(int id) throws NotFoundException {
		float timer = timerDao.getTime(id);
		return new SkillTimer(id, timer);
	}

	@Override
	public void checkTime(SkillTimer time) {
		try {
			if (timerDao.getTime(time.getId()) > time.getTime()) {
				timerDao.saveTime(time);
			}
		}
		catch ( NotFoundException e ) {
			timerDao.saveTime(time);
		}
		
	}

}
