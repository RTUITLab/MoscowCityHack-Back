package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.ModeratorInfo;
import com.example.moscowcityhackback.services.ModeratorInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModeratorInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private ModeratorInfoService ModeratorInfoService;

    public List<ModeratorInfo> createModerator(ModeratorInfo moderator) {
        return ModeratorInfoService.create(moderator);
    }

    public ModeratorInfo updateModerator(long id, ModeratorInfo moderator) {
        return ModeratorInfoService.update(id, moderator);
    }

    public List<ModeratorInfo> deleteModerator(long id) {
        return ModeratorInfoService.delete(id);
    }

    public List<ModeratorInfo> deleteModerators() {
        return ModeratorInfoService.deleteAll();
    }
}
