package santa.sistemas.tiendas_efe_springboot.service.entity_service;

import java.util.List;

public interface iGenericService<Entity,ID> {
    public Entity Add(Entity entity);
    public Entity Update(Entity entity);
    public void Delete(ID id);
    public Entity FindById(ID id);
    public List<Entity> FindAll();
}
