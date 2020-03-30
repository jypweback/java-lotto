package com.lotto.domain;

import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/23
 * Github : http://github.com/jypweback
 * Description :
 */
public class UserLotto {

    private List<Integer> lottoNumbers;

    public UserLotto(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "UserLotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}