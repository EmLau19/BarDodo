import com.pi4j.io.gpio.*;

public class Vanne_Controller {
    final GpioController gpio = GpioFactory.getInstance();
    final GpioPinDigitalOutput vanne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,"vanne", PinState.LOW); // la c'est branche au pin 1 ah ouais ouais ouais

    void action_Vanne ()
    {
        vanne.pulse(2000, true);
    }


}
