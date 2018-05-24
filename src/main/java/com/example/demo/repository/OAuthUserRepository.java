package com.example.demo.repository;

import com.example.demo.entity.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lichenxing on 2017/2/15.
 */
public interface OAuthUserRepository extends JpaRepository<OAuthUser, Long> {

    OAuthUser findByProviderTypeAndProviderUserId(String providerType, String providerUserId);

    OAuthUser findByProviderTypeAndTenantIdAndAgentUserId(String providerType, Integer tenantId, String agentUserId);

}
