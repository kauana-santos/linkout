package com.linkout.user.mapper;

import com.linkout.user.dtos.UserResponse;
import com.linkout.user.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-05T10:29:39-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserResponse> toResponseList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        for ( User user : users ) {
            list.add( toResponse( user ) );
        }

        return list;
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String username = null;
        String profileImageUrl = null;
        String bio = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        username = user.getUsername();
        profileImageUrl = user.getProfileImageUrl();
        bio = user.getBio();

        UserResponse userResponse = new UserResponse( id, name, email, username, profileImageUrl, bio );

        return userResponse;
    }
}
