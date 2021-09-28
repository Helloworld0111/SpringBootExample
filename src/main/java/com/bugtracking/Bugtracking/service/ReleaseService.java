package com.bugtracking.Bugtracking.service;



import com.bugtracking.Bugtracking.entity.ReleaseTable;

import java.util.List;

public interface ReleaseService {
   ReleaseTable save(ReleaseTable release);
    void deleteById(Integer id);
    List<ReleaseTable> findByAll();
    ReleaseTable findById(Integer id);
}
