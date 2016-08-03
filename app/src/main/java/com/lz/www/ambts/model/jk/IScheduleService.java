package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.Schedule;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface IScheduleService {

    Schedule getOne(int id);

    List<Schedule> getList();

    int add(Schedule schedule);

    int delete(int id);

}
