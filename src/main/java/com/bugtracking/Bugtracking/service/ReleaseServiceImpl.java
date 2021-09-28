package com.bugtracking.Bugtracking.service;


import com.bugtracking.Bugtracking.entity.ReleaseTable;
import com.bugtracking.Bugtracking.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReleaseServiceImpl implements ReleaseService{
    @Autowired
    public final ReleaseRepository releaseRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    public ReleaseTable save(ReleaseTable release) {

        return releaseRepository.save(release);
    }

    public void deleteById(Integer id) {
       releaseRepository.deleteById(id);

    }

    public List<ReleaseTable> findByAll() {
        List<ReleaseTable> a=releaseRepository.findAll();
        return a;

    }
    public ReleaseTable findById(Integer id)
    {
        return releaseRepository.findById(id).get();

    }

}
