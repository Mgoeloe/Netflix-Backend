package com.NetflixCloneProject.Popcorn.Time.Repository;

import com.NetflixCloneProject.Popcorn.Time.Model.ApiModel;
import com.NetflixCloneProject.Popcorn.Time.Model.Icons;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class IconsRepoTest {
    @Autowired
    private IconsRepo repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void TestCreateIcons() {
        Icons iconsmodel = new Icons();
        iconsmodel.setIconTitle("Facebook");
        iconsmodel.setIconUrl("https://i.postimg.cc/wMhh0ptw/facebook-logo.png");
        System.out.println(iconsmodel.toString());
        Icons saveIcons = repo.save(iconsmodel);
        Icons existIcons = entityManager.find(Icons.class, saveIcons.getId());
        assertThat(existIcons.getId()).isEqualTo(iconsmodel.getId());

    }

}




