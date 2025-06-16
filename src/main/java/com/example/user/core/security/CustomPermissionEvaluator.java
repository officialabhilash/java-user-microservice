package com.example.user.core.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    public boolean hasPermission(Authentication authentication, Object group, Object permission, Object module) {
        if (authentication == null || group == null || permission == null || module == null) {
            return false;
        }
        String groupStr = group.toString().toUpperCase();
        String perm = permission.toString().toUpperCase();
        String mod = module.toString().toUpperCase();
        return authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .anyMatch(auth -> auth.equals(groupStr + "," + perm + "," + mod));
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication == null || targetDomainObject == null || permission == null) {
            return false;
        }
        String module = targetDomainObject.toString().toUpperCase();
        String perm = permission.toString().toUpperCase();
        // Check if any authority matches "*," + perm + "," + module
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(auth -> {
                    String[] parts = auth.split(",");
                    return parts.length == 3 && parts[1].equals(perm) && parts[2].equals(module);
                });
    }


    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Not used in this example
        return false;
    }
}