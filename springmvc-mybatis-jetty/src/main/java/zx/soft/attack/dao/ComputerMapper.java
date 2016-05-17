package zx.soft.attack.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import zx.soft.attack.model.Computer;

public interface ComputerMapper {
	
	
	@Select("select * from `computer` WHERE `id` = #{id}")
	public List<Computer> getAllComputer(@Param("id") int id);

}
