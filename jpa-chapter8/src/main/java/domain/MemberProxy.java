package domain;

public class MemberProxy extends Member{
    Member target = null;

    public String getName(){
        if(target == null){

            // 2 초기화 요청 ( 실제 엔티티가 생성되어 있지 않으면 영속성 컨텍스트에 실제 엔티티 생성을 요청하는 과정)
            // 3 DB 조회
            // 4 실제 엔티티 생성 및 참조 보관
            // this.target = ... ;
        }

        // 5 target.getName();
        return target.getUsername();
    }
}
