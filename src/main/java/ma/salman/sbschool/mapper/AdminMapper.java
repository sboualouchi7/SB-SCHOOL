package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.AdminDTO;
import ma.salman.sbschool.Models.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDTO toDto(Admin admin);
    Admin toEntity(AdminDTO adminDTO);
    List<AdminDTO> toDtoList(List<Admin> admins);
    void updateEntityFromDto(AdminDTO dto, @MappingTarget Admin entity);
}
