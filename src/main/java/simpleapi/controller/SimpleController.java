package simpleapi.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import simpleapi.domain.ResponseError;
import simpleapi.domain.SkillTimer;
import simpleapi.exception.NotFoundException;
import simpleapi.service.TimerService;

@RestController
public class SimpleController {

	@Autowired
	private TimerService timerService;
	
	@RequestMapping(value="/timer/{id}", method=RequestMethod.GET)
	public @ResponseBody Serializable getTime(@PathVariable("id") int id) throws Exception {
		System.out.println("Getting ID "+ id);
		return timerService.getBestTime(id);
	}
	
	@RequestMapping(value="/timer", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> saveTime(@RequestBody SkillTimer skillTimer) throws Exception {
		System.out.println("Saving ID "+ skillTimer.getId() +" " + skillTimer.getTime());
		timerService.checkTime(skillTimer);
		
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<String>(status);
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value={NotFoundException.class})
	public @ResponseBody ResponseError handle404(Exception e, HttpServletResponse response) throws Exception {
		return new ResponseError(404, e.getMessage());
	}
}
