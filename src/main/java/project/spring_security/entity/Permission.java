package project.spring_security.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Entity(name = "permission")
public class Permission {

    @Id
    @Column(name = "permission_id")
    private long permissionId;
    @NotEmpty
    @Column(name = "permission_name")
    private String permissionName;

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
