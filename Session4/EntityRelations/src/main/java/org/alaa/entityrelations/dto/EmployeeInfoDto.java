package org.alaa.entityrelations.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.alaa.entityrelations.model.Address;
import org.alaa.entityrelations.model.Project;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeInfoDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal salary;
    private Address address;
    private String departmentName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> projectName;


    public void setProjectName(List<Project> projects) {
        if (projects != null){
            this.projectName = projects.stream().map(Project::getProjectName).toList();
        }

    }
}
