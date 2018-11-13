package pl.coderslab;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SomeComp {

    public List<Smurf> getList() {
        List<Smurf> smurfs = new ArrayList<>();
        smurfs.add(new Smurf("papa"));
        smurfs.add(new Smurf("smerfetka"));
        smurfs.add(new Smurf("spioch"));
        return smurfs;
    }

}
