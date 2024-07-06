package uz.pdp.modul9.repostiroy;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.modul9.entity.Upload;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {

}
