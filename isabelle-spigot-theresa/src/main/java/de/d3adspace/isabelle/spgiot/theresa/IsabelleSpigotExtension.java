package de.d3adspace.isabelle.spgiot.theresa;

import com.google.inject.Module;
import de.d3adspace.isabelle.core.extension.IsabelleExtension;
import de.d3adspace.isabelle.spigot.AbstractSpigotExtension;
import de.d3adspace.theresa.core.Theresa;
import de.d3adspace.theresa.core.TheresaFactory;

public abstract class IsabelleSpigotExtension extends AbstractSpigotExtension implements IsabelleExtension, Module {

    private final Theresa theresa = TheresaFactory.create(this);

    @Override
    public void bootstrap() {

    }

    @Override
    public void start() {

        theresa.startLifeCycle();
    }

    @Override
    public void tearDown() {

        theresa.stopLifeCycle();
    }

    @Override
    public boolean isAlive() {

        return true;
    }
}
