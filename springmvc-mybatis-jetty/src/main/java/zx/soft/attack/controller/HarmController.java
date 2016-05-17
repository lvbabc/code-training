package zx.soft.attack.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import zx.soft.attack.model.Computer;
import zx.soft.attack.service.ComputerService;

@Controller
@RequestMapping("/test")
public class HarmController {

	@Inject
	private ComputerService computer;

	/**
	 * 查询
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody List<Computer> getHarmInfo(HttpServletRequest request) {
		int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
		int rows = request.getParameter("rows") == null ? 10 : Integer.parseInt(request.getParameter("rows"));
		List<Computer> list = computer.getComputerData();
		return list;
	}

}
