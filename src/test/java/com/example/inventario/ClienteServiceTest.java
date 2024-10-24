package com.example.inventario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.example.inventario.interfaces.ClienteInterface;
import com.example.inventario.models.Cliente;
import com.example.inventario.services.ClienteService;

public class ClienteServiceTest {

	@InjectMocks
    private ClienteService clienteService; 

    @Mock
    private ClienteInterface clienteInterface;

	@BeforeEach
	  public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	@Test
	public void testGuardarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCedula("12345");
		cliente.setNombre("Cliente Test");
		cliente.setDireccion("Dirección de Cliente Test");
		cliente.setTelefono("111-1111");

		when(clienteInterface.save(any(Cliente.class))).thenReturn(cliente);

		int resultado = clienteService.guardar(cliente);

		assertThat(resultado).isEqualTo(1);
		verify(clienteInterface, times(1)).save(cliente);
	}

	@Test
	public void testListarClientes() {
		Cliente cliente1 = new Cliente();
		cliente1.setCedula("12345");
		cliente1.setNombre("Cliente 1");
		cliente1.setDireccion("Dirección Cliente 1");
		cliente1.setTelefono("111-1111");

		Cliente cliente2 = new Cliente();
		cliente2.setCedula("54321");
		cliente2.setNombre("Cliente 2");
		cliente2.setDireccion("Dirección Cliente 2");
		cliente2.setTelefono("222-2222");

		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);

		when(clienteInterface.findAll()).thenReturn(clientes);

		List<Cliente> resultado = clienteService.listar();

		assertThat(resultado).isEqualTo(clientes);
		verify(clienteInterface, times(1)).findAll();
	}

	@Test
	public void testBorrarCliente() {
		int idClienteABorrar = 1;

		
		doNothing().when(clienteInterface).deleteById(idClienteABorrar);

		clienteService.borrar(idClienteABorrar);

		verify(clienteInterface, times(1)).deleteById(idClienteABorrar);
	}

	@Test
	public void testConsultarCliente() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setCedula("12345");
		cliente.setNombre("Cliente Consulta");
		cliente.setDireccion("Dirección Cliente Consulta");
		cliente.setTelefono("333-3333");

		when(clienteInterface.findById(cliente.getId())).thenReturn(Optional.of(cliente));

		Optional<Cliente> encontrado = clienteService.consultauncliente(cliente.getId());

		assertThat(encontrado).isPresent();
		assertThat(encontrado.get().getNombre()).isEqualTo("Cliente Consulta");
		verify(clienteInterface, times(1)).findById(cliente.getId());
	}

	public ClienteServiceTest() {
		// TODO Auto-generated constructor stub
	}

}
