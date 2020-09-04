package com.formacionbdi.springboot.app.productos.controllers;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ProductoController {

    @Autowired
    private Environment env;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/list")
    public List<Producto> list() {
        return iProductoService.findAll()
                .stream()
                .map(producto -> {
                    //producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                    producto.setPort(port);
                    return producto;
                }).collect(Collectors.toList());
    }

    @GetMapping("/list/{id}")
    public Producto detail(@PathVariable Long id) throws Exception {
        Producto producto = iProductoService.findById(id);
        // producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        producto.setPort(port);
/*
        boolean ok = false;
        if (ok == false){
            throw new Exception("No se pudo cargar el producto");
        }


 */

/*
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

 */
        return producto;
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto producto) {

        return iProductoService.save(producto);

    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
        Producto productodb = iProductoService.findById(id);
        productodb.setNombre(producto.getNombre());
        productodb.setPrecio(producto.getPrecio());
        productodb.setCreateAt(producto.getCreateAt());

        return iProductoService.save(productodb);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        iProductoService.deleteById(id);
    }
}
