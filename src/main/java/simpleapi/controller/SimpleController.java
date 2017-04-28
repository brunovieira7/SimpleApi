package simpleapi.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import simpleapi.response.json.TimerResponse;

@RestController
@RequestMapping("/api")
public class SimpleController {

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public @ResponseBody Serializable getTimer(@PathVariable("id") String id) throws Exception {
		return new TimerResponse(1, 102);
	}
}
