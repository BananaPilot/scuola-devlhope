package com.teamproject1.scuoledevelhope.classes.user.dto;

import com.teamproject1.scuoledevelhope.classes.role.dto.RoleDashboard;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponse;
import org.springframework.http.HttpStatus;

public class DashboardDto extends BaseResponse {

    private String username;
    private RoleDashboard role;
    private UserRegistry userRegistry;

    public String getUsername() {
        return username;
    }

    public RoleDashboard getRole() {
        return role;
    }

    public UserRegistry getUserRegistry() {
        return userRegistry;
    }

    public DashboardDto(HttpStatus httpStatus, String message, String description, String username, RoleDashboard role, UserRegistry userRegistry) {
        super(httpStatus, message, description);
        this.username = username;
        this.role = role;
        this.userRegistry = userRegistry;
    }

    public DashboardDto() {}


    public static final class DashboardDtoBuilder {
        private String username;
        private RoleDashboard role;
        private UserRegistry userRegistry;
        private HttpStatus httpStatus;
        private String message;
        private String description;

        private DashboardDtoBuilder() {
        }

        public static DashboardDtoBuilder aDashboardDto() {
            return new DashboardDtoBuilder();
        }

        public static DashboardDtoBuilder map(User user) {
            return DashboardDtoBuilder.aDashboardDto()
                    .withUsername(user.getUsername())
                    .withUserRegistry(user.getUserRegistry());
        }

        public DashboardDtoBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public DashboardDtoBuilder withRole(RoleDashboard role) {
            this.role = role;
            return this;
        }

        public DashboardDtoBuilder withUserRegistry(UserRegistry userRegistry) {
            this.userRegistry = userRegistry;
            return this;
        }

        public DashboardDtoBuilder withHttpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public DashboardDtoBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public DashboardDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DashboardDto build() {
            return new DashboardDto(httpStatus, message, description, username, role, userRegistry);
        }
    }
}
