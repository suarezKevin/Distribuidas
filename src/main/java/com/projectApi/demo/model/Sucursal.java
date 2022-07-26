package com.projectApi.demo.model;

import com.projectApi.demo.model.dto.NotificacionDto;
import com.projectApi.demo.model.dto.SucursalDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "sucursal")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer idsucursal;

    @Column(name = "nombre_sucursal", nullable = false, unique = true)
    private String nombresucursal;

    @Column(name="provincia_sucursal", nullable = false)
    private String provinciasucursal;

    @Column(name = "ciudad_sucursal", nullable = false)
    private String ciudadsucursal;

    @Column(name = "direccion_sucursal", nullable = false)
    private String direccionsucursal;

    @Column(name = "telefono_sucursal", nullable = false)
    private String telefonosucursal;

    @Column(name = "latitud_sucursal", nullable = false)
    private String latitudsucursal;

    @Column(name = "longitud_sucursal", nullable = false)
    private String longitudsucursal;

//    @OneToOne
//    @JoinColumn(name = "contacto_sucursal", referencedColumnName = "idcontacto")
//    private Contacto contactosucursal;

    @OneToMany(
            mappedBy = "sucursal",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Notificacion> notificaciones = new ArrayList<>();

    @OneToMany(
            mappedBy = "sucursalpertenece",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Contacto> contactosList = new ArrayList<>();

    public void  addNotificacion(Notificacion notificacion){
        notificaciones.add(notificacion);
    }

    public void removeNotificacion(Notificacion notificacion){
        notificaciones.remove(notificacion);
    }

    public void  addContacto(Contacto contacto){
        contactosList.add(contacto);
    }

    public void removeContacto(Contacto contacto){
        contactosList.remove(contacto);
    }

    public static Sucursal from(SucursalDto sucursalDto){
        Sucursal sucursal = new Sucursal();
        sucursal.setIdsucursal(sucursalDto.getIdsucursal());
        sucursal.setNombresucursal(sucursalDto.getNombresucursal());
        sucursal.setProvinciasucursal(sucursalDto.getProvinciasucursal());
        sucursal.setCiudadsucursal(sucursalDto.getCiudadsucursal());
        sucursal.setDireccionsucursal(sucursalDto.getDireccionsucursal());
        sucursal.setTelefonosucursal(sucursalDto.getTelefonosucursal());
        sucursal.setLatitudsucursal(sucursalDto.getLatitudsucursal());
        sucursal.setLongitudsucursal(sucursalDto.getLongitudsucursal());
        //if (Objects.nonNull(sucursalDto.getNotificacionListDto())){
        //    sucursal.setNotificaciones(sucursalDto.getNotificacionListDto().stream().map(Notificacion::from).collect(Collectors.toList()));
       // }
       // if (Objects.nonNull(sucursalDto.getContactosListDto())){
       //     sucursal.setContactosList(sucursalDto.getContactosListDto().stream().map(Contacto::from).collect(Collectors.toList()));
       // }


        return sucursal;
    }
}
