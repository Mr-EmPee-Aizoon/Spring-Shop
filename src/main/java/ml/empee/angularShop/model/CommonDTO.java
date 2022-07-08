package ml.empee.angularShop.model;

import org.springframework.beans.BeanUtils;

public abstract class CommonDTO<E, T extends CommonDTO<E, T>> {

    public T copyFrom(E source) {
        BeanUtils.copyProperties(source, this);
        return (T) this;
    }

    public E copyTo(E target) {
        BeanUtils.copyProperties(this, target);
        return target;
    }

}
