package simpleapi.dao.impl;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import simpleapi.dao.TimerDao;
import simpleapi.domain.SkillTimer;
import simpleapi.exception.NotFoundException;

@Repository("timerDaoMemoryImpl")
public class TimerDaoMemoryImpl implements TimerDao{

	private HashMap<Integer, Float> database;
	
	@Override
	public float getTime(int id) throws NotFoundException {
		if (database == null)
			initDatabase();
			
		if (database.get(Integer.valueOf(id)) == null) {
			throw new NotFoundException("ID " + id + " not found.");
		}
		
		return database.get(Integer.valueOf(id));
	}
	
	private void initDatabase() {
		database = new HashMap<>();
		database.put(Integer.valueOf(1), Float.valueOf(10));
		database.put(Integer.valueOf(2), Float.valueOf(30));
		database.put(Integer.valueOf(3), Float.valueOf(20));
	}

	@Override
	public void saveTime(SkillTimer timer) {
		database.put(Integer.valueOf(timer.getId()), Float.valueOf(timer.getTime()));
	}

}
