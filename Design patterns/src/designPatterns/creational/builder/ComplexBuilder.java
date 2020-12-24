package designPatterns.creational.builder;

// if we need more builders to build one object

class ComplexPerson {
	// address
	public String streetAddress, postcode, city;

	// employment
	public String companyName, position;
	public int annualIncome;

	@Override
	public String toString() {
		return "Person{" + "streetAddress='" + streetAddress + '\'' + ", postcode='" + postcode + '\'' + ", city='"
				+ city + '\'' + ", companyName='" + companyName + '\'' + ", position='" + position + '\''
				+ ", annualIncome=" + annualIncome + '}';
	}
}

// builder facade
class ComplexPersonBuilder {
	// the object we're going to build
	protected ComplexPerson person = new ComplexPerson(); // reference!

	public PersonJobBuilder works() {
		return new PersonJobBuilder(person);
	}

	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(person);
	}

	public ComplexPerson build() {
		return person;
	}
}

class PersonAddressBuilder extends ComplexPersonBuilder {
	public PersonAddressBuilder(ComplexPerson person) {
		this.person = person;
	}

	public PersonAddressBuilder at(String streetAddress) {
		person.streetAddress = streetAddress;
		return this;
	}

	public PersonAddressBuilder withPostcode(String postcode) {
		person.postcode = postcode;
		return this;
	}

	public PersonAddressBuilder in(String city) {
		person.city = city;
		return this;
	}
}

class PersonJobBuilder extends ComplexPersonBuilder {
	public PersonJobBuilder(ComplexPerson person) {
		this.person = person;
	}

	public PersonJobBuilder at(String companyName) {
		person.companyName = companyName;
		return this;
	}

	public PersonJobBuilder asA(String position) {
		person.position = position;
		return this;
	}

	public PersonJobBuilder earning(int annualIncome) {
		person.annualIncome = annualIncome;
		return this;
	}
}

class BuilderFacetsDemo {
	public static void main(String[] args) {
		ComplexPersonBuilder pb = new ComplexPersonBuilder();
		ComplexPerson person = pb.lives().at("123 London Road").in("London").withPostcode("SW12BC").works()
				.at("Fabrikam").asA("Engineer").earning(123000).build();
		System.out.println(person);
	}
}