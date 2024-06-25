package com.horizon.to_do_app.Repositories;

import com.horizon.to_do_app.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Repo extends JpaRepository<Item, Long> {

}
