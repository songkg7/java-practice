package adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SamsungAdapter implements JapanElectronicProduct {

    private final Samsung samsung;

    @Override
    public void v110() {
        samsung.v220();
    }

    @Override
    public void electricPressure() {
        samsung.electricPressure();
    }
}
