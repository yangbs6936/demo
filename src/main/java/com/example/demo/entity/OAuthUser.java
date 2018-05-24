package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * OAuthUser
 *
 * @author Chenxing Li
 * @date 2017/2/15 14:33
 */
@Data
@Entity
@Table(name = "oauth_user")
public class OAuthUser {

    @Id
    @SequenceGenerator(name="seq",sequenceName="oauth_user_id_SEQ",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "providerType", length = 50)
    private String providerType;

    @Column(name = "providerUserId", length = 100)
    private String providerUserId;

    @Column(name = "tenantId")
    private Integer tenantId;

    @Column(name = "agentUserId", length = 36)
    private String agentUserId;

    @Column(name = "createAt")
    private Date createAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;

}
