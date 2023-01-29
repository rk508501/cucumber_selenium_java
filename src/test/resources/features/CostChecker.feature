Feature: Verify User get any help with NHS costs online service

  Background: Navigate to NHS Cost Checker Tool
    Given Open the NHS Cost Checker tool url
    And Accept the analytics cookies
    And Click on Start Now

  Scenario Outline: User living in England and don't claim any benefits or tax credit and don't live in home care and put all other circumstances randomly
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    And Enter details about pregnant or given birth as <field>
    And Enter details about injury or illness in armed forces as <war>
    And Enter about diabetes as <disease>
    And Enter about diabetes medication as <medicine>
    And Enter details about home care as <permanent> and <careLocalCouncil>
    And Enter details about savings or investment
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country | claim | credit | field | war | permanent | careLocalCouncil | disease | medicine |
      | England | No    | No     | Yes   | Yes | No        | No               | Yes     | Yes      |
      | England | No    | No     | No    | Yes | Yes       | No               | Yes     | Yes      |
      | England | No    | No     | No    | No  | No        | No               | Yes     | Yes      |
      | England | No    | No     | Yes   | Yes | Yes       | No               | Yes     | Yes      |

  Scenario Outline: User living in Wales and don't claim any benefits or tax credit and don't live in home care and put all other circumstances randomly
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    And Enter details about pregnant or given birth as <field>
    And Enter details about injury or illness in armed forces as <war>
    And Enter about diabetes as <disease>
    And Enter about glaucoma
    And Enter details about home care as <permanent> and <careLocalCouncil>
    And Enter details about savings or investment
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country | claim | credit | field | war | permanent | careLocalCouncil | disease |
      | Wales   | No    | No     | Yes   | Yes | No        | No               | Yes     |
      | Wales   | No    | No     | No    | Yes | Yes       | No               | Yes     |
      | Wales   | No    | No     | No    | No  | No        | No               | Yes     |
      | Wales   | No    | No     | Yes   | Yes | Yes       | No               | Yes     |

  Scenario Outline: User living in Scotland and don't claim any benefits or tax credit and don't live in home care and put all other circumstances randomly
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    And Enter details about pregnant or given birth as <field>
    And Enter details about injury or illness in armed forces as <war>
    And Enter details about home care as <permanent> and <careLocalCouncil>
    And Enter details about savings or investment
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country  | claim | credit | field | war | permanent | careLocalCouncil |
      | Scotland | No    | No     | Yes   | Yes | No        | No               |
      | Scotland | No    | No     | No    | Yes | Yes       | No               |
      | Scotland | No    | No     | No    | No  | No        | No               |
      | Scotland | No    | No     | Yes   | Yes | Yes       | No               |

  Scenario Outline: User living in England/Wales/Scotland and claim any benefits or tax credits and don't get paid Universal Credits
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country  | claim | credit | careLocalCouncil |
      | Scotland | Yes   | No     | No               |
      | England  | Yes   | No     | No               |
      | Wales    | Yes   | No     | No               |

  Scenario Outline: User living in England/Wales/Scotland and claim any benefits or tax credits and recieve Universal Credits payment
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country  | claim | credit | careLocalCouncil |
      | Scotland | Yes   | Yes    | No               |
      | England  | Yes   | Yes    | No               |
      | Wales    | Yes   | Yes    | No               |

  Scenario Outline: User living in England and live permanently in home care and need help from local council
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    And Enter details about pregnant or given birth as <field>
    And Enter details about injury or illness in armed forces as <war>
    And Enter about diabetes as <disease>
    And Enter about diabetes medication as <medicine>
    And Enter details about home care as <permanent> and <careLocalCouncil>
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country | claim | credit | field | war | permanent | careLocalCouncil | disease | medicine |
      | England | No    | No     | Yes   | Yes | Yes       | Yes              | Yes     | Yes      |

  Scenario Outline: User living in Wales and live permanently in home care and need help from local council
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    And Enter details about pregnant or given birth as <field>
    And Enter details about injury or illness in armed forces as <war>
    And Enter about diabetes as <disease>
    And Enter about glaucoma
    And Enter details about home care as <permanent> and <careLocalCouncil>
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country | claim | credit | field | war | permanent | careLocalCouncil | disease |
      | Wales   | No    | No     | Yes   | Yes | Yes       | Yes              | Yes     |

  Scenario Outline: User living in Scotland and live permanently in home care and need help from local council
    Given I am living in Country as <country>
    When I put circumstances as GP practice in Scotland or live in Highland and Island
    And Select Random Country is your dental practise in
    And Enter Date of Birth
    And Enter Random Details about Live with partner
    And Enter details about claim any benefit or tax credit as <claim> and universal credit as <credit>
    And Enter details about pregnant or given birth as <field>
    And Enter details about injury or illness in armed forces as <war>
    And Enter details about home care as <permanent> and <careLocalCouncil>
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country  | claim | credit | field | war | permanent | careLocalCouncil |
      | Scotland | No    | No     | Yes   | Yes | Yes       | Yes              |

  Scenario Outline: User living in Northern Ireland
    Given I am living in Country as <country>
    Then Get a result and check whether you get any help with NHS cost pass parameter as <claim> and <credit> and <careLocalCouncil>

    Examples: 
      | country          | claim | credit | careLocalCouncil |
      | Northern_Ireland | NA    | NA     | NA               |
