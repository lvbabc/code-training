package zx.soft.attack.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zx.soft.attack.dao.ComputerMapper;
import zx.soft.attack.model.Computer;


@Service
public class ComputerService {

	@Inject
	private ComputerMapper computerMapper;


	//获取每个区域的电脑数
	public List<Computer> getComputerData() {
		return computerMapper.getAllComputer(1);
	}

	//	public static void main(String[] args) {
	//		System.out.println(new ComputerService().getComputerData());
	//	}
}
