package com.example.inventario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.inventario.interfaces.ProductoInterface;
import com.example.inventario.models.Producto;
import com.example.inventario.services.ProductoService;

@SpringBootTest
public class ProductoServiceTest {
    
    @InjectMocks
    private ProductoService productoService;
    
    @Mock
    private ProductoInterface productoInterface;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testGuardarProducto() {
        Producto producto = new Producto();
        producto.setNombre("Producto Test");
        producto.setDescripcion("Descripción del producto test");
        producto.setValor(100);
        producto.setCantidad(10);
        producto.setEstado("activo");

        when(productoInterface.save(any(Producto.class))).thenReturn(producto);

        int resultado = productoService.guardar(producto);

        assertThat(resultado).isEqualTo(1);
        verify(productoInterface, times(1)).save(producto);
    }

    @Test
    public void testListarProductoActivos() {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setEstado("activo");
        
        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setEstado("activo");
        
        List<Producto> productos = Arrays.asList(producto1, producto2);
        
        when(productoInterface.findByEstado("activo")).thenReturn(productos);
        
        List<Producto> resultado = productoService.listar();
        
        assertThat(resultado).isEqualTo(productos);
        verify(productoInterface, times(1)).findByEstado("activo");
    }

    @Test
    public void testListarProductosInactivos() {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setEstado("inactivo");

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setEstado("inactivo");

        List<Producto> productos = Arrays.asList(producto1, producto2);

        when(productoInterface.findByEstado("inactivo")).thenReturn(productos);

        List<Producto> resultado = productoService.listarinactivos();

        assertThat(resultado).isEqualTo(productos);
        verify(productoInterface, times(1)).findByEstado("inactivo");
    }

    @Test
    public void testConsultarProducto() {
        Producto producto = new Producto();
        producto.setNombre("Producto Test");
        producto.setDescripcion("Descripción del producto test");
        producto.setValor(100);
        producto.setCantidad(10);
        producto.setEstado("activo");

        when(productoInterface.findById(anyInt())).thenReturn(Optional.of(producto));

        Optional<Producto> encontrado = productoService.consultaunproducto(producto.getId());

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getNombre()).isEqualTo("Producto Test");
        verify(productoInterface, times(1)).findById(producto.getId());
    }
}

