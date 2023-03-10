package com.pc.stockcontrol.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllowPrintStacktrace
@Data
@Entity
public class Part {

    @Id
//    @Column(nullable = false)
    private String partNo;
    private String kanban;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "part")
    private List<Bom> bom;

}
