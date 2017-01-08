package com.outlook.sftjun.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.outlook.sftjun.domain.Image;

/**
 *
 * @author jdmr
 */
@Repository
@Transactional
public class ImageDao {
    
    private static final Logger log = LoggerFactory.getLogger(ImageDao.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional(readOnly = true)
    public List<Image> list() {
        log.debug("List of images");
        Query query = currentSession().getNamedQuery("images");
        List<Image> images = query.list();
        return images;
    }

    public Image create(Image image) {
        log.debug("Creating image");
        currentSession().save(image);
        return image;
    }

    @Transactional(readOnly = true)
    public Image get(Long id) {
        log.debug("Getting image {}", id);
        Image image = (Image) currentSession().get(Image.class, id);
        return image;
    }

    public void delete(Image image) {
        log.debug("Deleting image {}", image.getName());
        currentSession().delete(image);
    }
    
}
