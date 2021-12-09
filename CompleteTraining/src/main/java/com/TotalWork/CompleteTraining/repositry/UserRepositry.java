package com.TotalWork.CompleteTraining.repositry;

import com.TotalWork.CompleteTraining.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry  extends JpaRepository<User,Long> {
}
